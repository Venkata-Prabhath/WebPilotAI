import { useEffect, useState } from "react";
import Statistics from "../components/dashboard/Statistics";
import RecentTasks from "../components/dashboard/RecentTasks";
import { getTasks } from "../api/taskApi";

const Dashboard = () => {
  const [tasks, setTasks] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchTasks = async () => {
      try {
        const data = await getTasks();
        setTasks(data);
      } catch (error) {
        console.error("Failed to fetch tasks:", error);
      } finally {
        setLoading(false);
      }
    };
    fetchTasks();
  }, []);

  return (
    <div className="space-y-8">
      <Statistics />
      {loading ? (
        <p className="text-slate-500">Loading tasks...</p>
      ) : (
        <RecentTasks tasks={tasks} />
      )}
    </div>
  );
};

export default Dashboard;