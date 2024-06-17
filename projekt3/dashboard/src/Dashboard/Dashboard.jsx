import Header from '../Header/Header';
import MainContent from '../MainContent/MainContent';
import './dashboard.css'

export default function Dashborad() {
    return (
        <>
            <div className="dashboard">
                <Header></Header>


                <div className="sidebar"></div>
                <div className="main">
                    <MainContent></MainContent>
                </div>
            </div>
        </>
    );
}