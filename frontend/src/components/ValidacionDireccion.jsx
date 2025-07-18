import { useEffect, useState } from "react";
import axios from "axios";
import Header from "./Header";

export default function FormularioDireccion() {
    // Listas para los selects
    const [estados, setEstados] = useState([]);
    const [municipios, setMunicipios] = useState([]);
    const [localidades, setLocalidades] = useState([]);
    const [colonias, setColonias] = useState([]);
    // Errores y mensajes
    const [errores, setErrores] = useState({});
    const [mensaje, setMensaje] = useState("");
    const [mensajeTipo, setMensajeTipo] = useState("");

    // Estado del formulario
    const [formulario, setFormulario] = useState({
        cp: "",
        estado: "",
        municipio: "",
        localidad: "",
        colonia: "",
        calle: ""
    });

    // Al montar el componente: cargar estados
    useEffect(() => {
        axios.get("http://localhost:8080/api/estados")
            .then(response => setEstados(response.data))
            .catch(error => console.error("Error al cargar estados:", error));
    }, []);

    // Manejador genérico de cambios en inputs/selects
    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormulario({ ...formulario, [name]: value });

        if (errores[name]) {
            const nuevosErrores = { ...errores };
            delete nuevosErrores[name];
            setErrores(nuevosErrores);
        }
    };

    // Al cambiar estado: cargar municipios y localidades
    const handleEstadoChange = (e) => {
        const estado = e.target.value;

        setFormulario({
            ...formulario,
            estado,
            municipio: "",
            localidad: "",
            colonia: ""
        }); // limpiamos también colonia

        if (estado) {
            axios.get(`http://localhost:8080/api/municipios?estado=${estado}`)
                .then(res => setMunicipios(res.data))
                .catch(err => console.error("Error al cargar municipios:", err));

            axios.get(`http://localhost:8080/api/localidades?estado=${estado}`)
                .then(res => setLocalidades(res.data))
                .catch(err => console.error("Error al cargar localidades:", err));
        } else {
            setMunicipios([]);
            setLocalidades([]);
        }

        setColonias([]); // Limpiar colonias por si venía de un CP anterior
    };

    // Al perder foco en el input de CP: buscar datos automáticos
    const handleCPBlur = () => {
        const cp = formulario.cp;
        if (!cp) return;

        axios.get(`http://localhost:8080/api/direccion?cp=${cp}`)
            .then(res => {
                const { estado, municipio, localidad } = res.data;

                // Validar que realmente vengan datos
                if (!estado || !municipio || !localidad) {
                    lanzarErrorDeCP(); // función auxiliar que limpia y muestra error
                    return;
                }

                setFormulario(prev => ({
                    ...prev,
                    estado,
                    municipio,
                    localidad
                }));

                // Cargar municipios y localidades según estado
                axios.get(`http://localhost:8080/api/municipios?estado=${estado}`)
                    .then(resp => setMunicipios(resp.data))
                    .catch(err => console.error("Error al cargar municipios:", err));

                axios.get(`http://localhost:8080/api/localidades?estado=${estado}`)
                    .then(resp => setLocalidades(resp.data))
                    .catch(err => console.error("Error al cargar localidades:", err));

                // Colonias con el CP
                axios.get(`http://localhost:8080/api/colonias?cp=${cp}`)
                    .then(resp => {
                        if (resp.data.length === 0) {
                            lanzarErrorDeCP();
                        } else {
                            setColonias(resp.data);
                        }
                    })
                    .catch(err => {
                        lanzarErrorDeCP();
                    });
            })
            .catch(err => {
                lanzarErrorDeCP();
            });
    };

    const lanzarErrorDeCP = () => {
        setMensaje("❌ Código postal no encontrado");
        setMensajeTipo("error");

        setFormulario(prev => ({
            ...prev,
            estado: "",
            municipio: "",
            localidad: "",
            colonia: ""
        }));

        setMunicipios([]);
        setLocalidades([]);
        setColonias([]);
        setErrores(prev => ({ ...prev, cp: true }));

        setTimeout(() => setMensaje(""), 4000);
    };

    // Enviar formulario para validación
    const handleSubmit = (e) => {
        e.preventDefault();
        setMensaje("");

        const { estado, municipio, localidad, colonia, calle, cp } = formulario;

        // Verifica campos vacíos
        const nuevosErrores = {};
        if (!estado) nuevosErrores.estado = true;
        if (!municipio) nuevosErrores.municipio = true;
        if (!localidad) nuevosErrores.localidad = true;
        if (!colonia) nuevosErrores.colonia = true;
        if (!calle) nuevosErrores.calle = true;
        if (!cp) nuevosErrores.cp = true;

        if (Object.keys(nuevosErrores).length > 0) {
            setErrores(nuevosErrores);
            setMensaje("Todos los campos son obligatorios.");
            setMensajeTipo("error");
            setTimeout(() => setMensaje(""), 4000);
            return;
        }

        setErrores({}); // limpiar errores si todo está bien

        axios.post("http://localhost:8080/api/validacion", { estado, municipio, localidad, cp })
            .then(res => {
                setMensaje("✅ Dirección válida");
                setMensajeTipo("success");
                // Limpieza del mensaje automático
                setTimeout(() => setMensaje(""), 4000);
            })
            .catch(err => {
                const msg = typeof err.response?.data === "string"
                    ? err.response.data
                    : err.response?.data?.message || "Error de validación";
                setMensaje(msg);
                setMensajeTipo("error");
                setTimeout(() => setMensaje(""), 4000);
            });

    };

    return (
        <>
            <Header />

            <div className="min-h-screen bg-zinc-950 text-white flex items-center justify-center pt-20 px-4">
                <form
                    className="w-full max-w-2xl bg-zinc-900 p-8 rounded-2xl shadow-lg border border-zinc-700 space-y-6"
                    onSubmit={handleSubmit}
                >
                    <h2 className="text-3xl font-bold text-center text-white">Dirección</h2>

                    {/* Código Postal */}
                    <div>
                        <label className="block text-sm font-semibold mb-1">Código Postal</label>
                        <input
                            name="cp"
                            value={formulario.cp}
                            onChange={handleChange}
                            onBlur={handleCPBlur}
                            className={`block w-full p-2 rounded border ${errores.cp ? "border-red-500" : "border-zinc-600"
                                } bg-zinc-800 text-white placeholder-zinc-400 focus:outline-none focus:ring-2 focus:ring-indigo-500`} placeholder="Ej. 45130"
                        />
                    </div>

                    {/* Selects */}
                    <div className="grid grid-cols-1 sm:grid-cols-2 gap-4">
                        <div>
                            <label className="block text-sm font-semibold mb-1">Estado</label>
                            <select
                                name="estado"
                                value={formulario.estado}
                                onChange={handleEstadoChange}
                                className={`block w-full p-2 rounded border ${errores.estado ? "border-red-500" : "border-zinc-600"
                                    } bg-zinc-800 text-white placeholder-zinc-400 focus:outline-none focus:ring-2 focus:ring-indigo-500 ${estados.length === 0 ? "opacity-50 cursor-not-allowed" : ""
                                    }`}
                            >
                                <option value="">Seleccione...</option>
                                {estados.map(est => (
                                    <option key={est.clave} value={est.clave}>{est.nombre}</option>
                                ))}
                            </select>
                        </div>

                        <div>
                            <label className="block text-sm font-semibold mb-1">Municipio</label>
                            <select
                                name="municipio"
                                value={formulario.municipio}
                                onChange={handleChange}
                                className={`block w-full p-2 rounded border ${errores.municipio ? "border-red-500" : "border-zinc-600"
                                    } bg-zinc-800 text-white placeholder-zinc-400 focus:outline-none focus:ring-2 focus:ring-indigo-500 ${municipios.length === 0 ? "opacity-50 cursor-not-allowed" : ""
                                    }`}
                            >
                                <option value="">Seleccione el estado</option>
                                {municipios.map(mun => (
                                    <option key={mun.clave} value={mun.clave}>{mun.descripcion}</option>
                                ))}
                            </select>
                        </div>

                        <div>
                            <label className="block text-sm font-semibold mb-1">Localidad</label>
                            <select
                                name="localidad"
                                value={formulario.localidad}
                                onChange={handleChange}
                                className={`block w-full p-2 rounded border ${errores.localidad ? "border-red-500" : "border-zinc-600"
                                    } bg-zinc-800 text-white placeholder-zinc-400 focus:outline-none focus:ring-2 focus:ring-indigo-500 ${localidades.length === 0 ? "opacity-50 cursor-not-allowed" : ""
                                    }`}
                            >
                                <option value="">Seleccione el municipio...</option>
                                {localidades.map(loc => (
                                    <option key={loc.clave} value={loc.clave}>{loc.descripcion}</option>
                                ))}
                            </select>
                        </div>

                        <div>
                            <label className="block text-sm font-semibold mb-1">Colonia</label>
                            <select
                                name="colonia"
                                value={formulario.colonia}
                                onChange={handleChange}
                                className={`block w-full p-2 rounded border ${errores.colonia ? "border-red-500" : "border-zinc-600"
                                    } bg-zinc-800 text-white placeholder-zinc-400 focus:outline-none focus:ring-2 focus:ring-indigo-500 ${colonias.length === 0 ? "opacity-50 cursor-not-allowed" : ""
                                    }`}
                            >
                                <option value="">Seleccione...</option>
                                {colonias.map(col => (
                                    <option key={`${col.clave}-${col.cp}`} value={col.descripcion}>
                                        {col.descripcion}
                                    </option>
                                ))}
                            </select>
                        </div>
                    </div>

                    {/* Calle y número */}
                    <div>
                        <label className="block text-sm font-semibold mb-1">Calle y número</label>
                        <input
                            name="calle"
                            value={formulario.calle}
                            onChange={handleChange}
                            className={`block w-full p-2 rounded border ${errores.calle ? "border-red-500" : "border-zinc-600"
                                } bg-zinc-800 text-white placeholder-zinc-400 focus:outline-none focus:ring-2 focus:ring-indigo-500`} placeholder="Ej. Av. Chapultepec #123"
                        />
                    </div>

                    {/* Botón */}
                    <button
                        type="submit"
                        className="w-full py-2 bg-indigo-600 hover:bg-indigo-700 rounded-md text-white font-semibold transition"
                    >
                        Continuar
                    </button>

                    {/* Mensaje */}
                    {mensaje && (
                        <div
                            className={`mt-4 text-sm text-center font-semibold ${mensajeTipo === "success"
                                ? "text-green-500"
                                : mensajeTipo === "error"
                                    ? "text-red-500"
                                    : "text-yellow-500"
                                }`}
                        >
                            {mensaje}
                        </div>
                    )}

                </form>
            </div>
        </>
    );

}
