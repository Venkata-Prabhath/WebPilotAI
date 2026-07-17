const Button = ({
    children,
    type = "button",
    onClick,
    className = "",
    disabled = false
}) => {

    return (
        <button
            type={type}
            disabled={disabled}
            onClick={onClick}
            className={`px-5 py-3 rounded-xl bg-blue-600 hover:bg-blue-700 disabled:bg-slate-700 disabled:cursor-not-allowed text-white font-semibold transition ${className}`}
        >
            {children}
        </button>
    );

};

export default Button;