import { Button } from "react-bootstrap";
import { Col, Container, Row } from "react-bootstrap";

function Search(){
    return (
        <div>
            <Container>
                <Row>
                    <Col></Col>
                    <Col>
                        <input type="text"/>
                        <Button>Search</Button>
                    </Col>
                    <Col></Col>
                </Row>
            </Container>
        </div>
    )
}

export default Search;