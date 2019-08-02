package myapp

import example.MultiRequest
import example.PartialRequest
import example.Request
import example.StandardRequest
import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional
import org.hibernate.engine.spi.SessionFactoryImplementor

class BootStrap {

    SessionFactoryImplementor sessionFactory

    def init = { servletContext ->
        initRequests()
        listRequests()
    }

    def destroy = {
    }

    @Transactional
    void initRequests() {
        StandardRequest standardRequest = new StandardRequest()
        standardRequest.save()

        MultiRequest multiRequest = new MultiRequest()
        multiRequest.addToPartialRequests(new PartialRequest())
        multiRequest.addToPartialRequests(new PartialRequest())
        multiRequest.save()
    }

    @ReadOnly
    void listRequests() {
        sessionFactory.currentSession.clear()

        assert Request.list().size() == 4
        assert StandardRequest.list().size() == 1
        assert MultiRequest.list().size() == 1

        MultiRequest multiRequest = MultiRequest.list().first()
        assert multiRequest.partialRequests.size() == 2 // exception happens here
    }
}
