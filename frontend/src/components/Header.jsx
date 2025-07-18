import Logo from '../assets/logo.svg'

const Header = () => {
  return (
    <header className="fixed top-0 left-0 w-full z-50 bg-zinc-900 border-b border-zinc-700 px-6 py-4 flex items-center justify-between">
      <div className="flex items-center gap-4">
        <div className="w-10 h-10 rounded-full overflow-hidden">
          <img src={Logo} alt="Logo" className="w-full h-full object-cover" />
        </div>
        <h1 className="text-lg sm:text-xl font-bold text-white leading-tight">
          José de Jesús González Téllez
        </h1>
      </div>

      <span className="text-sm text-zinc-400 hidden sm:inline">
         Java (Spring Boot) · React · TailwindCSS · PostgreSQL
      </span>
    </header>
  );
};

export default Header;
