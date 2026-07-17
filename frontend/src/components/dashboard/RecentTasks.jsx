const RecentTasks = ({ tasks = [] }) => {

    return (

        <div className="bg-slate-900 border border-slate-800 rounded-2xl p-6">

            <h2 className="text-xl text-white font-semibold mb-5">

                Recent Tasks

            </h2>

            {tasks.length === 0 ? (

                <p className="text-slate-500">

                    No tasks available

                </p>

            ) : (

                <div className="space-y-4">

                    {tasks.map((task) => (

                        <div
                            key={task.id}
                            className="flex justify-between items-center border-b border-slate-800 pb-3"
                        >

                            <div>

                                <p className="text-white">

                                    {task.prompt}

                                </p>

                                <small className="text-slate-500">

                                    {task.status}

                                </small>

                            </div>

                        </div>

                    ))}

                </div>

            )}

        </div>

    );

};

export default RecentTasks;