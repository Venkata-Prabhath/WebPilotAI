import { motion } from "framer-motion";

const DashboardCard = ({ title, value, icon, color = "text-blue-400" }) => {

    return (

        <motion.div
            whileHover={{ scale: 1.03 }}
            className="bg-slate-900 border border-slate-800 rounded-2xl p-6 shadow-xl"
        >

            <div className="flex justify-between items-center">

                <div>

                    <p className="text-slate-400 text-sm">

                        {title}

                    </p>

                    <h2 className="text-3xl font-bold text-white mt-2">

                        {value}

                    </h2>

                </div>

                <div className={color}>

                    {icon}

                </div>

            </div>

        </motion.div>

    );

};

export default DashboardCard;