import {
    Cpu,
    Globe,
    CheckCircle,
    Clock
} from "lucide-react";

const Statistics = () => {

    const stats = [

        {
            title: "Executions",
            value: 15,
            icon: <Cpu size={28}/>
        },

        {
            title: "Visited Sites",
            value: 43,
            icon: <Globe size={28}/>
        },

        {
            title: "Completed",
            value: 12,
            icon: <CheckCircle size={28}/>
        },

        {
            title: "Pending",
            value: 3,
            icon: <Clock size={28}/>
        }

    ];

    return (

        <div className="grid md:grid-cols-4 gap-6">

            {stats.map((stat) => (

                <div
                    key={stat.title}
                    className="bg-slate-900 rounded-2xl border border-slate-800 p-6"
                >

                    <div className="text-blue-400 mb-3">

                        {stat.icon}

                    </div>

                    <h2 className="text-white text-3xl font-bold">

                        {stat.value}

                    </h2>

                    <p className="text-slate-400 mt-2">

                        {stat.title}

                    </p>

                </div>

            ))}

        </div>

    );

};

export default Statistics;