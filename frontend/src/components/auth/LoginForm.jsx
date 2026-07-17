import { useState, useContext } from "react";
import { Link, useNavigate } from "react-router-dom";
import { AuthContext } from "../../context/AuthContext";
import { login } from "../../api/authApi";

const LoginForm = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const { loginUser } = useContext(AuthContext);
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await login({ email, password });
      if (response && response.token) {
        loginUser(response.token);
        navigate("/dashboard");
      }
    } catch (err) {
      alert("Login failed");
    }
  };

  return (
    <form onSubmit={handleSubmit} className="space-y-4">
      <h2 className="text-xl text-white">Login</h2>
      <input 
        type="email" placeholder="Email" value={email} 
        onChange={(e) => setEmail(e.target.value)} 
        className="w-full p-2 bg-gray-800 text-white border rounded" 
      />
      <input 
        type="password" placeholder="Password" value={password} 
        onChange={(e) => setPassword(e.target.value)} 
        className="w-full p-2 bg-gray-800 text-white border rounded" 
      />
      <button type="submit" className="w-full p-2 bg-blue-600 text-white rounded">
        Login
      </button>
      <div className="text-center mt-4">
        <p className="text-sm text-gray-400">
          Don't have an account?{" "}
          <Link to="/register" className="text-blue-500 hover:underline">
            Create one
          </Link>
        </p>
      </div>
    </form>
  );
};

export default LoginForm;