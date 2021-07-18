import axios from "axios";
import { useState } from "react";
import { Button } from "react-bootstrap";
import { Col, Container, Row, Card } from "react-bootstrap";

function Search() {
    const [result, setResult] = useState(null);
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [itemId, setItemId] = useState('');
    const [plans, setPlans] = useState(null);
    const [planName, setPlanName] = useState('');
    const [planPrice, setPlanPrice] = useState('');
    const [planData, setPlanData] = useState('');

    function doSearch() {
        axios.get('http://localhost:8000/service-product/searchProduct')
            .then(res => setResult(res.data.searchResult));
        axios.get('http://localhost:8000/service-plan/getPlans')
            .then(res => setPlans(res.data.listOfPlans));
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
                        <input type="text" />
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
                                                <img src={r.imageUrl} />
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
                <Row>
                    {
                        plans === null ? (<Col></Col>)
                            :
                            (plans.map((p, k) => (
                                <Col>
                                    <Container>
                                        <Row className="text-center">
                                            <Col>
                                                <Card style={{ width: '18rem' }}>
                                                    
                                                    <Card.Body>
                                                        <Card.Title>{p.planName}</Card.Title>
                                                        <Card.Text>
                                                            Pay {p.price} for {p.planName} plan per month. Data allowance {p.data} MB.
    </Card.Text>
                                                        <Button variant="primary">Select</Button>
                                                    </Card.Body>
                                                </Card>
                                                <label>{p.planName}</label>
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