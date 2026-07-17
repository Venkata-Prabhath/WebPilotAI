import useAuth from "../hooks/useAuth";
import { useNavigate } from "react-router-dom";

const Profile = () => {
  const { logoutUser } = useAuth();
  const navigate = useNavigate();

  const handleLogout = () => {
    logoutUser();
    navigate("/");
  };

  return (
    <div className="bg-slate-900 border border-slate-800 rounded-2xl p-8">
      <h1 className="text-3xl text-white font-bold mb-6">Profile</h1>
      <button 
        onClick={handleLogout}
        className="bg-red-600 hover:bg-red-700 px-6 py-2 rounded-xl text-white"
      >
        Logout
      </button>
    </div>
  );
};

export default Profile;