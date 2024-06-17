import { useState } from 'react';
import './dateComponent.css'

export default function DateComponent(){

    const date =  new Date();
    const  month = date.toLocaleString('default', { month: 'long' });
    return(
        <>
        <div className='dateContainer'>
            <div className='timeContainer'>
                <span className='time'>{date.getDay()}. {month}</span>
            </div>
        </div>
        </>
    )
    ;
}