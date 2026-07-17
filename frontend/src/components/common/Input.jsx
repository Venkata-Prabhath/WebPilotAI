const Input = ({
    type = "text",
    placeholder,
    value,
    onChange,
    name
}) => {

    return (

        <input
            type={type}
            placeholder={placeholder}
            value={value}
            name={name}
            onChange={onChange}
            className="w-full rounded-xl bg-slate-800 border border-slate-700 px-4 py-3 text-white outline-none"
        />

    );

};

export default Input;