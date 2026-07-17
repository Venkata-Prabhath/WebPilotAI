import {
    LayoutDashboard,
    Globe,
    ListChecks,
    Settings,
    User
} from "lucide-react";

import { NavLink } from "react-router-dom";

const Sidebar = () => {

    const menus = [

        {
            name: "Dashboard",
            path: "/dashboard",
            icon: <LayoutDashboard size={20}/>
        },

        {
            name: "Browser",
            path: "/browser",
            icon: <Globe size={20}/>
        },

        {
            name: "Tasks",
            path: "/tasks",
            icon: <ListChecks size={20}/>
        },

        {
            name: "Profile",
            path: "/profile",
            icon: <User size={20}/>
        },

        {
            name: "Settings",
            path: "/settings",
            icon: <Settings size={20}/>
        }

    ];

    return (

        <aside className="w-72 bg-slate-900 border-r border-slate-800 h-screen">

            <div className="text-center py-8">

                <h2 className="text-white text-3xl font-bold">

                    WebPilot

                </h2>

                <p className="text-slate-500 mt-2">

                    AI Browser Agent

                </p>

            </div>

            <nav className="px-5 space-y-2">

                {menus.map((menu)=>(

                    <NavLink

                        key={menu.path}

                        to={menu.path}

                        className={({isActive})=>

                            `flex items-center gap-4 p-4 rounded-xl transition ${
                                isActive
                                ? "bg-blue-600 text-white"
                                : "text-slate-400 hover:bg-slate-800 hover:text-white"
                            }`
                        }

                    >

                        {menu.icon}

                        {menu.name}

                    </NavLink>

                ))}

            </nav>

        </aside>

    );

};

export default Sidebar;