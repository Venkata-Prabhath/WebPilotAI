import { motion } from "framer-motion";

const AuthLayout = ({ children }) => {

    return (
        <div className="min-h-screen bg-[#0f172a] flex items-center justify-center px-4">

            <motion.div
                initial={{ opacity: 0, y: 25 }}
                animate={{ opacity: 1, y: 0 }}
                transition={{ duration: 0.4 }}
                className="w-full max-w-md rounded-2xl border border-slate-700 bg-slate-900/80 backdrop-blur-lg shadow-2xl p-8"
            >
                <div className="mb-8 text-center">

                    <h1 className="text-4xl font-bold text-white">
                        WebPilot
                    </h1>

                    <p className="text-slate-400 mt-2">
                        AI Browser Automation
                    </p>

                </div>

                {children}

            </motion.div>
        </div>
    );
};

export default AuthLayout;