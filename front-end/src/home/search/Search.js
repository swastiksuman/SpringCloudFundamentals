import axios from "axios";
import { useState } from "react";
import { Button } from "react-bootstrap";
import { Col, Container, Row } from "react-bootstrap";

function Search(){
    const [result, setResult] = useState(null);
    function doSearch(){
        axios.get('http://localhost:8081/searchProduct')
            .then(res=>setResult(res.data.searchResult));
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
        </div>
    )
}

export default Search;