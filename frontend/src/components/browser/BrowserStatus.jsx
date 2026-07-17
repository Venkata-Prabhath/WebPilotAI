import { Activity } from "lucide-react";

const BrowserStatus = ({ status = "Idle" }) => {

    const color =
        status === "Running"
            ? "bg-green-500"
            : status === "Failed"
            ? "bg-red-500"
            : "bg-yellow-500";

    return (

        <div className="bg-slate-900 border border-slate-800 rounded-2xl p-5">

            <div className="flex items-center justify-between">

                <div className="flex items-center gap-3">

                    <Activity className="text-blue-400" />

                    <h2 className="text-white font-semibold">
                        Browser Status
                    </h2>

                </div>

                <div className="flex items-center gap-2">

                    <div className={`w-3 h-3 rounded-full ${color}`} />

                    <span className="text-slate-300">
                        {status}
                    </span>

                </div>

            </div>

        </div>

    );

};

export default BrowserStatus;