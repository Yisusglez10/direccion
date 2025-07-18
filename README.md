# 📍 Proyecto Dirección (Java + Spring Boot + React)

Este proyecto proporciona una API REST y un formulario web para obtener y validar información de direcciones en México. Usa **Java con Spring Boot**,
**PostgreSQL** en el backend, y **React + TailwindCSS** en el frontend.

---

## 📁 Estructura del repositorio

```
direccion/
├── backend/          # Proyecto Java Spring Boot
├── frontend/         # Proyecto React
├── README.md
└── .gitignore
```

---

## 🚀 Funcionalidades principales

### 🧩 Parte 1: Carga inicial y dependencias

- ✅ Al cargar la pantalla, se muestran los **estados disponibles** en el select "Estado".
- ✅ Al seleccionar un estado, se cargan automáticamente sus **municipios** y **localidades**.
- ✅ Las **colonias** no se cargan hasta que se indique un código postal.

### 🧩 Parte 2: Autocompletado por Código Postal

- ✅ Al escribir un **código postal** y perder el foco:
  - Se selecciona automáticamente el **estado correspondiente**.
  - Se cargan **municipios y localidades** asociadas.
  - Se seleccionan automáticamente los valores correctos según el CP.
  - Se muestra la lista de **colonias disponibles** para el CP ingresado.
- ✅ Si el código postal no existe, se muestra un **mensaje de error** adecuado.

### 🧩 Parte 3: Validación de datos al continuar

- ✅ Al hacer clic en **"Continuar"**, se valida que todos los campos estén completos y que los datos coincidan con los catálogos.
- ✅ Si la dirección es válida, se muestra un **mensaje de éxito**.
- ✅ Si hay errores, se muestra un **mensaje con la causa del error**.

---

📌 Todos los campos son requeridos y están validados desde el frontend y el backend.

---

## 🔌 Endpoints REST

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET`  | `/api/estados` | Lista de estados |
| `GET`  | `/api/municipios?estado=JAL` | Municipios del estado |
| `GET`  | `/api/localidades?estado=JAL` | Localidades del estado |
| `GET`  | `/api/direccion?cp=45130` | Estado, municipio y localidad del CP |
| `GET`  | `/api/colonias?cp=45130` | Colonias del código postal |
| `POST` | `/api/validacion` | Valida dirección completa |

### 🧪 Ejemplo de validación

```json
POST /api/validacion
{
  "estado": "JAL",
  "municipio": "120",
  "localidad": "10",
  "cp": "45130"
}
```

---

## 💻 Tecnologías usadas

- ☕ Java 17
- 🧰 Spring Boot 3.5.3
- 🐘 PostgreSQL
- ⚙️ Maven
- 🧩 Lombok
- 🌐 React + TailwindCSS (frontend)
- 🧪 Validaciones con DTOs
- 🔒 CORS configurado

---

## 📦 Estructura del backend (Spring Boot)

```
backend/
└── src/
    └── main/
        ├── java/com/yisusglez/direccion/
        │   ├── config/
        │   │   └── WebConfig.java
        │   ├── controller/
        │   │   ├── ColoniaController.java
        │   │   ├── DireccionController.java
        │   │   ├── EstadoController.java
        │   │   ├── LocalidadController.java
        │   │   ├── MunicipioController.java
        │   │   └── ValidacionController.java
        │   ├── dto/
        │   │   ├── ColoniaDTO.java
        │   │   ├── DireccionDTO.java
        │   │   ├── EstadoDTO.java
        │   │   ├── LocalidadDTO.java
        │   │   ├── MunicipioDTO.java
        │   │   └── ValidacionDireccionDTO.java
        │   ├── model/
        │   │   ├── CodigoPostal.java
        │   │   ├── Colonia.java
        │   │   ├── ColoniaId.java
        │   │   ├── Estado.java
        │   │   ├── Localidad.java
        │   │   ├── LocalidadId.java
        │   │   ├── Municipio.java
        │   │   └── MunicipioId.java
        │   ├── repository/
        │   │   ├── CodigoPostalRepository.java
        │   │   ├── ColoniaRepository.java
        │   │   ├── EstadoRepository.java
        │   │   ├── LocalidadRepository.java
        │   │   ├── MunicipioRepository.java
        │   └── DireccionApplication.java
        └── resources/
            └── application.properties
```

---

## 🎨 Estructura del frontend (React + Tailwind)

```
frontend/
├── src/
│   ├── assets/
│   │   └── logo.svg
│   ├── components/
│   │   ├── Header.jsx
│   │   └── ValidacionDireccion.jsx
│   ├── App.jsx
│   ├── main.jsx
│   └── index.css
├── index.html
├── tailwind.config.js
├── vite.config.js
└── package.json
```

---

## ▶️ Cómo ejecutar localmente

### 🧠 Backend (Java)

1. Configura PostgreSQL en el archivo:  
   `backend/src/main/resources/application.properties`

2. Ejecuta el backend:

```bash
cd backend
./mvnw spring-boot:run
```

### 🧠 Frontend (React)

```bash
cd frontend
npm install
npm run dev
```

Esto iniciará el frontend en:  
[http://localhost:5173](http://localhost:5173)

---

## 🌐 Versión en línea

Puedes ver el proyecto en funcionamiento aquí:  
🔗 [https://direccion.yisusglez.com](https://direccion.yisusglez.com)

---

## 🧑‍💻 Autor

Desarrollado por **José de Jesús González Téllez**  
🧷 Proyecto técnico · 2025

---

## ✅ Comentarios finales

- Código ordenado, validado y responsivo.
- Proyecto ideal para formularios de dirección en México.
- Preparado para ampliarse o desplegarse fácilmente.
