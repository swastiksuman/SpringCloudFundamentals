import { useState } from 'react';
import axios from 'axios';
import Button from 'react-bootstrap/Button';
import Search from './search/Search';

function Home() {

    const [result, setResult] = useState(null);
    


    function doTest() {
        axios.get('http://localhost:8080/doTransaction')
            .then(res => {
                console.log(res);
                setResult(res.data);
            }
            );
        console.log('***Test***');
    }

    return (
        <div>
            <Search></Search>
        </div>
    )
}

export default Home;