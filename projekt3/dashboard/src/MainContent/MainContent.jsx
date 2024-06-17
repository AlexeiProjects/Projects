import { useEffect, useState } from 'react';
import ToDoInput from '../TodoInput/ToDoInput';
import TodoList from '../TodoList/TodoList';
import './mainContent.css'
import DateComponent from '../DateComponent/DateComponent';
import Clock from '../Clock/Clock';
import BalanceOverview from '../BalanceOverview/BalanceOverview';
import InputTransaction from '../InputTransaction/InputTransaction';
import TransacitonOverview from '../TransactionOverview/TransactionOverview';


export default function MainContent() {

    const [balance, setBalance] = useState(0);

    const [toDos, setToDos] = useState([]);

    const [newToDo, setToDo] = useState("")


    const [newTransaction, setNewTransaction] = useState({
        description: '',
        amount: 0
    });


    const [Transactions, setTransactions] = useState([])


    function handelInputDescriptionTransactionChange(event) {
        setNewTransaction({ ...newTransaction, description: event.target.value })
    }
    function handelInputAmountTransactionChange(event) {
        setNewTransaction({ ...newTransaction, amount: event.target.value })
    }

    function handelAddTransaction() {
        setTransactions(t => [newTransaction,...t ])
        
        const newBelance = parseInt(balance) + parseInt(newTransaction.amount);
        console.log(newBelance)
        setBalance(newBelance);

        setNewTransaction({
            description: '',
            amount: 0
        })
    }

    function handleInputChange(event) {
        setToDo(event.target.value)
    }

    function handleAddTodo() {
        // if empty
        if (newToDo.trim() !== "") {

            setToDos(t => [...t, newToDo])
            setToDo("")
        }

    }

    function handleDeleteToDo(index) {

        const updatedToDos = toDos.filter((todo, i) => i !== index)
        setToDos(updatedToDos)

    }

    return (
        <>
            <div className='main-wrapper'>
                <div className='Content1'><DateComponent></DateComponent></div>
                <div className='Content2'><ToDoInput newToDo={newToDo} handleInputChange={handleInputChange} addToDo={handleAddTodo}></ToDoInput></div>
                <div className='Content3'><BalanceOverview balance={balance}></BalanceOverview></div>
                <div className='Content4'><Clock></Clock></div>
                <div className='Content5'><InputTransaction
                    newTransaction={newTransaction}
                    handelInputDescriptionTransactionChange={handelInputDescriptionTransactionChange}
                    handelInputAmountTransactionChange={handelInputAmountTransactionChange}
                    handelAddTransaction={handelAddTransaction}
                ></InputTransaction></div>
                <div className='Content6'><TodoList toDos={toDos} handleDeleteToDo={handleDeleteToDo}></TodoList></div>
                <div className='Content7'> <TransacitonOverview Transactions={Transactions}></TransacitonOverview></div>
            </div>
        </>
    )
        ;
}