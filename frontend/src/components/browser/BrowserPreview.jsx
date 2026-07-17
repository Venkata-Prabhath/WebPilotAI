import { MonitorSmartphone } from "lucide-react";

const BrowserPreview = ({ currentUrl, screenshot }) => {
    return (
        <div className="bg-slate-900 border border-slate-800 rounded-2xl overflow-hidden">

            <div className="flex items-center gap-3 border-b border-slate-800 px-5 py-4">

                <MonitorSmartphone className="text-blue-400" />

                <h2 className="text-white font-semibold">
                    Browser Preview
                </h2>

            </div>

            <div className="px-5 py-3 border-b border-slate-800">

                <input
                    readOnly
                    value={currentUrl || "No page loaded"}
                    className="w-full bg-slate-800 rounded-lg px-4 py-2 text-slate-300 outline-none"
                />

            </div>

            <div className="flex items-center justify-center h-[500px] bg-slate-950">

                {screenshot ? (

                    <img
                        src={screenshot}
                        alt="Browser Preview"
                        className="w-full h-full object-cover"
                    />

                ) : (

                    <div className="text-center">

                        <MonitorSmartphone
                            size={70}
                            className="mx-auto text-slate-600"
                        />

                        <p className="mt-5 text-slate-500">

                            Browser preview will appear here

                        </p>

                    </div>

                )}

            </div>

        </div>
    );
};

export default BrowserPreview;