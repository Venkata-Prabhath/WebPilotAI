import Sidebar from "./Sidebar";
import Header from "./Header";
import Footer from "./Footer";
import { Outlet } from "react-router-dom";

const MainLayout = () => {

    return (

        <div className="flex bg-[#020617] min-h-screen">

            <Sidebar />

            <div className="flex-1 flex flex-col">

                <Header />

                <main className="flex-1 p-8 overflow-y-auto">

                    <Outlet />

                </main>

                <Footer />

            </div>

        </div>

    );

};

export default MainLayout;