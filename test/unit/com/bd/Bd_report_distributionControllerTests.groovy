package com.bd



import org.junit.*
import grails.test.mixin.*

@TestFor(Bd_report_distributionController)
@Mock(Bd_report_distribution)
class Bd_report_distributionControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/bd_report_distribution/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.bd_report_distributionInstanceList.size() == 0
        assert model.bd_report_distributionInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.bd_report_distributionInstance != null
    }

    void testSave() {
        controller.save()

        assert model.bd_report_distributionInstance != null
        assert view == '/bd_report_distribution/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/bd_report_distribution/show/1'
        assert controller.flash.message != null
        assert Bd_report_distribution.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/bd_report_distribution/list'


        populateValidParams(params)
        def bd_report_distribution = new Bd_report_distribution(params)

        assert bd_report_distribution.save() != null

        params.id = bd_report_distribution.id

        def model = controller.show()

        assert model.bd_report_distributionInstance == bd_report_distribution
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/bd_report_distribution/list'


        populateValidParams(params)
        def bd_report_distribution = new Bd_report_distribution(params)

        assert bd_report_distribution.save() != null

        params.id = bd_report_distribution.id

        def model = controller.edit()

        assert model.bd_report_distributionInstance == bd_report_distribution
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/bd_report_distribution/list'

        response.reset()


        populateValidParams(params)
        def bd_report_distribution = new Bd_report_distribution(params)

        assert bd_report_distribution.save() != null

        // test invalid parameters in update
        params.id = bd_report_distribution.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/bd_report_distribution/edit"
        assert model.bd_report_distributionInstance != null

        bd_report_distribution.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/bd_report_distribution/show/$bd_report_distribution.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        bd_report_distribution.clearErrors()

        populateValidParams(params)
        params.id = bd_report_distribution.id
        params.version = -1
        controller.update()

        assert view == "/bd_report_distribution/edit"
        assert model.bd_report_distributionInstance != null
        assert model.bd_report_distributionInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/bd_report_distribution/list'

        response.reset()

        populateValidParams(params)
        def bd_report_distribution = new Bd_report_distribution(params)

        assert bd_report_distribution.save() != null
        assert Bd_report_distribution.count() == 1

        params.id = bd_report_distribution.id

        controller.delete()

        assert Bd_report_distribution.count() == 0
        assert Bd_report_distribution.get(bd_report_distribution.id) == null
        assert response.redirectedUrl == '/bd_report_distribution/list'
    }
}
