import { useEffect, useState } from "react";
import BrowserToolbar from "../components/browser/BrowserToolbar";
import BrowserPreview from "../components/browser/BrowserPreview";
import BrowserConsole from "../components/browser/BrowserConsole";
import BrowserControls from "../components/browser/BrowserControls";
import BrowserStatus from "../components/browser/BrowserStatus";
import { connectWebSocket, disconnectWebSocket } from "../api/wsClient";

const Browser = () => {
  const [logs, setLogs] = useState([]);
  const [currentUrl, setCurrentUrl] = useState("");

  useEffect(() => {
    const client = connectWebSocket();

    client.onConnect = () => {
      client.subscribe("/topic/browser/logs", (message) => {
        const newLog = JSON.parse(message.body);
        setLogs((prev) => [...prev, newLog]);
      });
    };

    return () => disconnectWebSocket();
  }, []);

  const handleNavigate = (url) => {
    setCurrentUrl(url);
  };

  const handleRefresh = () => {
    console.log("Refresh");
  };

  const handleBack = () => {
    console.log("Back");
  };

  const handleForward = () => {
    console.log("Forward");
  };

  const handleHome = () => {
    setCurrentUrl("");
  };

  return (
    <div className="space-y-6">
      <BrowserToolbar
        currentUrl={currentUrl}
        onNavigate={handleNavigate}
        onRefresh={handleRefresh}
        onBack={handleBack}
        onForward={handleForward}
        onHome={handleHome}
      />

      <BrowserControls />
      <BrowserStatus />
      <BrowserPreview />
      <BrowserConsole logs={logs} />
    </div>
  );
};

export default Browser;