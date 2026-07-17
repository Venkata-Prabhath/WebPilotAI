import {
    Globe,
    RefreshCcw,
    ArrowLeft,
    ArrowRight,
    House
} from "lucide-react";

const BrowserToolbar = ({
    currentUrl,
    onNavigate,
    onRefresh,
    onBack,
    onForward,
    onHome
}) => {

    return (

        <div className="bg-slate-900 border border-slate-800 rounded-2xl p-4">

            <div className="flex items-center gap-3">

                <button
                    onClick={onBack}
                    className="p-2 rounded-lg bg-slate-800 hover:bg-slate-700"
                >
                    <ArrowLeft className="text-white" size={18} />
                </button>

                <button
                    onClick={onForward}
                    className="p-2 rounded-lg bg-slate-800 hover:bg-slate-700"
                >
                    <ArrowRight className="text-white" size={18} />
                </button>

                <button
                    onClick={onRefresh}
                    className="p-2 rounded-lg bg-slate-800 hover:bg-slate-700"
                >
                    <RefreshCcw className="text-white" size={18} />
                </button>

                <button
                    onClick={onHome}
                    className="p-2 rounded-lg bg-slate-800 hover:bg-slate-700"
                >
                    <House className="text-white" size={18} />
                </button>

                <div className="flex-1 relative">

                    <Globe
                        size={18}
                        className="absolute left-3 top-3 text-slate-400"
                    />

                    <input
                        value={currentUrl}
                        onChange={(e) => onNavigate(e.target.value)}
                        placeholder="Enter URL..."
                        className="w-full pl-10 pr-4 py-2 rounded-lg bg-slate-800 border border-slate-700 text-white outline-none"
                    />

                </div>

            </div>

        </div>

    );

};

export default BrowserToolbar;