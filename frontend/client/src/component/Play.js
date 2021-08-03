import React from 'react'

const Play = ({mode}) => {
    return (
        <div>
            ROCK
            PAPER
            SCISORS
            {mode==="PVP" && 
            <div>
                ROCK
                PAPER
                SCISORS
            </div>}
        </div>
    )
}

export default Play
