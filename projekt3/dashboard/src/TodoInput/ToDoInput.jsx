import './toDoInput.css'

export default function ToDoInput({newToDo, handleInputChange, addToDo}){
    return(
    <>
    <h2 className='toDoHeading'>Add ToDo's</h2>
    <div className='toToInputContainer'>
        <input value={newToDo} onChange={handleInputChange} type="text" name="" id="" className='totoInput'/>
        <button onClick={addToDo} className='toDoBtn'>Add</button>
    </div>

    </>)

    ;
}