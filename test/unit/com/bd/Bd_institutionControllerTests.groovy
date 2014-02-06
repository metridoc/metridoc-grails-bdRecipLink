package com.bd



import org.junit.*
import grails.test.mixin.*

@TestFor(Bd_institutionController)
@Mock(Bd_institution)
class Bd_institutionControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/bd_institution/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.bd_institutionInstanceList.size() == 0
        assert model.bd_institutionInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.bd_institutionInstance != null
    }

    void testSave() {
        controller.save()

        assert model.bd_institutionInstance != null
        assert view == '/bd_institution/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/bd_institution/show/1'
        assert controller.flash.message != null
        assert Bd_institution.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/bd_institution/list'


        populateValidParams(params)
        def bd_institution = new Bd_institution(params)

        assert bd_institution.save() != null

        params.id = bd_institution.id

        def model = controller.show()

        assert model.bd_institutionInstance == bd_institution
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/bd_institution/list'


        populateValidParams(params)
        def bd_institution = new Bd_institution(params)

        assert bd_institution.save() != null

        params.id = bd_institution.id

        def model = controller.edit()

        assert model.bd_institutionInstance == bd_institution
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/bd_institution/list'

        response.reset()


        populateValidParams(params)
        def bd_institution = new Bd_institution(params)

        assert bd_institution.save() != null

        // test invalid parameters in update
        params.id = bd_institution.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/bd_institution/edit"
        assert model.bd_institutionInstance != null

        bd_institution.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/bd_institution/show/$bd_institution.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        bd_institution.clearErrors()

        populateValidParams(params)
        params.id = bd_institution.id
        params.version = -1
        controller.update()

        assert view == "/bd_institution/edit"
        assert model.bd_institutionInstance != null
        assert model.bd_institutionInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/bd_institution/list'

        response.reset()

        populateValidParams(params)
        def bd_institution = new Bd_institution(params)

        assert bd_institution.save() != null
        assert Bd_institution.count() == 1

        params.id = bd_institution.id

        controller.delete()

        assert Bd_institution.count() == 0
        assert Bd_institution.get(bd_institution.id) == null
        assert response.redirectedUrl == '/bd_institution/list'
    }
}
