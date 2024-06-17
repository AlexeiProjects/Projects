import './transactionOverview.css'

export default function TransacitonOverview({ Transactions }) {
    return (

        <div className='transacitonOverviewContainer'>
            <h3 className="thrid-heading">Transactions</h3>
            <ul className="transactions">

                {Transactions.map((transactions, index) =>

                    <li key={index} className={`transaction ${transactions.amount > 0 ? 'transaction--income' : 'transaction--expense'
                        }`}
                    >

                        <span className="transction__text">{transactions.description}</span>
                        <span className="transction__amount">{transactions.amount}</span>
                    </li>
                )}

            </ul>
        </div>
    );
}