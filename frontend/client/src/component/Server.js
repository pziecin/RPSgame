import React, { Component } from 'react'
import PropTypes from 'prop-types'

export class Server extends Component {
    constructor() {
        super()
      }

    componentWillMount() {
        this.getData()
      }

    getData() {
        var xhr = new XMLHttpRequest()
        xhr.addEventListener('load', () => {
          console.log(xhr.responseText)
        })

        xhr.open('GET', 'http://localhost:8001/predict')
        xhr.send()
      }

    render() {
        return (
            <div>

            </div>
        )
    }
}

export default Server
