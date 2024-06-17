import './balanceOverview.css'

export default function BalanceOverview({balance}) {
    return (
        <div className='balanceOverviewContainer'>
            <h1 class="balanceHeading">Your Balance</h1>
            <span class="balanceNumber">{balance}</span>
        </div>
    )
        ;
}


