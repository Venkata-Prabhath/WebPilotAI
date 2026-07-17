import { useState } from "react";
import { executeBrowserCommand } from "../../api/browserApi";

const BrowserControls = () => {
  const [command, setCommand] = useState("");
  const [loading, setLoading] = useState(false);

  const handleExecute = async () => {
    if (!command.trim()) return;
    setLoading(true);
    try {
      await executeBrowserCommand(command);
      setCommand(""); // Clear input on success
    } catch (error) {
      console.error("Execution failed:", error);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="bg-slate-900 border border-slate-800 rounded-2xl p-6 flex gap-4">
      <input
        value={command}
        onChange={(e) => setCommand(e.target.value)}
        placeholder="Enter browser command..."
        className="flex-1 bg-slate-800 rounded-xl px-4 py-3 text-white focus:outline-none focus:ring-2 focus:ring-blue-600"
      />
      <button 
        onClick={handleExecute}
        disabled={loading}
        className="bg-blue-600 hover:bg-blue-700 disabled:bg-slate-700 rounded-xl px-6 py-3 text-white transition-all"
      >
        {loading ? "Executing..." : "Run"}
      </button>
    </div>
  );
};

export default BrowserControls;