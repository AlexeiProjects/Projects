import './toDoList.css'

export default function TodoList({ toDos, handleDeleteToDo }) {
    return (
        <>
            <div className='todoListContainer'>
                <h2 className='todoListHeading'>Todo's</h2>
                <ul className='toDoList'>
                    {toDos.map((todo, index) =>

                        <li className='toDoItem'>
                            <span key={index} className='toDoItemText'>{todo}</span>
                            <button onClick={() => handleDeleteToDo(index)} className='toDoitemBtn'> X </button>
                        </li>
                    )}

                </ul>
            </div>

        </>

    )
        ;
}