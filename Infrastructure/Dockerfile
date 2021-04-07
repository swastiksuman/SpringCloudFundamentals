FROM rabbitmq:management
MAINTAINER swastiksuman@gmail.com
USER root
ADD init.sh /init.sh
RUN chmod 755 /init.sh
CMD ["/init.sh"]
