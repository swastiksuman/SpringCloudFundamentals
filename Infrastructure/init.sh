rabbitmqadmin -u guest -p guest -V / declare queue name=omq
rabbitmqadmin -u guest -p guest -V / declare exchange name=om-exchange type=direct
rabbitmqadmin -u guest -p guest -V / declare binding source=om-exchange destination=omq routing_key=routingkey
