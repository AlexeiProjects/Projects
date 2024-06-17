import { useEffect, useState } from 'react';
import './clock.css'

export default function Clock(){

    const [time,setTime ] = useState(new Date());

    useEffect(() =>{
        const intervalId = setInterval(() =>{
            setTime(new Date())
        }, 1000);

        return () =>{
            clearInterval(intervalId)
        }
    }, []);

    function formatTime(){
        const hours = time.getHours()
        const minutes = time.getMinutes()
        const seconds = time.getSeconds()

            return `${padZero(hours)}:${padZero(minutes)}:${padZero(seconds)}`;
    }

    function padZero(number){
        return (number < 10 ? "0" : "") + number
    }
    return(
    <>
        <div className='clockContainer'>
            <div className='clock'>
                <span className='clockTime'>{formatTime()}</span>
            </div>
        </div>
        
    </>
    );
}