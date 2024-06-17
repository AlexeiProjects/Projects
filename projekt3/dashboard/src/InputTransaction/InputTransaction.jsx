import './inputTransaction.css'

export default function InputTransaction({newTransaction,handelInputDescriptionTransactionChange,handelInputAmountTransactionChange,handelAddTransaction}) {
    return (
        <div className='inputTransactionContainer'>
          
            <div className='InputContainer'>


                <label for="description" className="labelTransaction">Description</label>
                <input id="description" type="text" className="inputTransaction " value={newTransaction.description} onChange={handelInputDescriptionTransactionChange}/>

                <label for="amount" className="labelTransaction">Amount</label>
                <input id="amount" type="number" className="inputTransaction " value={newTransaction.amount} onChange={handelInputAmountTransactionChange}/>
            </div>
            <button onClick={handelAddTransaction} class="Transactionbtn" type="submit">Submit</button>
        </div>

    );
}