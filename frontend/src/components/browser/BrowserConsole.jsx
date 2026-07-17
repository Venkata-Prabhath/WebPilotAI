import { Terminal } from "lucide-react";

const BrowserConsole = ({ logs = [] }) => {
    return (
        <div className="bg-slate-900 border border-slate-800 rounded-2xl p-5 h-[420px] overflow-y-auto">

            <div className="flex items-center gap-2 mb-4">

                <Terminal size={20} className="text-blue-400" />

                <h2 className="text-white font-semibold">
                    Browser Console
                </h2>

            </div>

            <div className="space-y-2 text-sm font-mono">

                {logs.length === 0 ? (

                    <p className="text-slate-500">
                        Waiting for execution...
                    </p>

                ) : (

                    logs.map((log, index) => (

                        <div
                            key={index}
                            className="text-green-400"
                        >
                            {log}
                        </div>

                    ))

                )}

            </div>

        </div>
    );
};

export default BrowserConsole;