import axios from "axios";
import { useState } from "react";
import { Button } from "react-bootstrap";
import { Col, Container, Row } from "react-bootstrap";

function Search(){
    const [result, setResult] = useState(null);
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [itemId, setItemId] = useState('');

    function doSearch(){
        axios.get('http://localhost:8000/service-product/searchProduct')
            .then(res=>setResult(res.data.searchResult));
        axios.get('http://localhost:8000/service-plan/getPlans')
            .then(res=>console.log(res));    
    }

    function placeOrder() {
        const placeOrder = {
            firstName: "Soujanya",
            lastName: "Talla",
            itemId: "123"
        };
        axios.post('http://localhost:8000/client-first/placeOrder', {
            firstName: firstName,
            lastName: lastName,
            itemId: itemId
        })
            .then(response => console.log(response));
    }
    return (
        <div>
            <Container>
                <Row>
                    <Col></Col>
                    <Col>
                        <input type="text"/>
                        <Button onClick={doSearch}>Search</Button>
                    </Col>
                    <Col></Col>
                </Row>
            </Container>
            <Container>
                <Row>
                {
                    result === null ? (<Col></Col>)
                    :
                    (result.map((r, k) => (
                        <Col>
                            <Container>
                                <Row className="text-center">
                                    <Col>
                                    <img src={r.imageUrl}/>
                                    </Col>
                                </Row>
                                <Row className="text-center">
                                    <Col>
                                        <label>{r.productName}</label>
                                    </Col>
                                </Row>
                            </Container>
                            

                        </Col>
                    ))
                    )    
                }
                </Row>
            </Container>
            <div>
                <label>First Name</label><input
                    onChange={(e) => setFirstName(e.target.value)} type="text" />
                <label>Last Name</label><input
                    onChange={(e) => setLastName(e.target.value)} type="text" />
                <label>Item Id</label><input
                    onChange={(e) => setItemId(e.target.value)} type="text" />
                <Button variant="primary" onClick={() => placeOrder()}>Submit Order</Button>
            </div>
        </div>
    )
}

export default Search;