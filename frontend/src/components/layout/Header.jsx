import { Bell, UserCircle } from "lucide-react";

const Header = () => {

    return (

        <header className="h-16 bg-slate-900 border-b border-slate-800 flex items-center justify-between px-8">

            <div>

                <h1 className="text-2xl font-bold text-white">
                    WebPilot
                </h1>

            </div>

            <div className="flex items-center gap-5">

                <button className="text-slate-400 hover:text-white">

                    <Bell size={22} />

                </button>

                <button className="text-slate-400 hover:text-white">

                    <UserCircle size={28} />

                </button>

            </div>

        </header>

    );

};

export default Header;