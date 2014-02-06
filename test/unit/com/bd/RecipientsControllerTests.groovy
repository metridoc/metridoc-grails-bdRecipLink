package com.bd



import org.junit.*
import grails.test.mixin.*

@TestFor(RecipientsController)
@Mock(Recipients)
class RecipientsControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/recipients/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.recipientsInstanceList.size() == 0
        assert model.recipientsInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.recipientsInstance != null
    }

    void testSave() {
        controller.save()

        assert model.recipientsInstance != null
        assert view == '/recipients/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/recipients/show/1'
        assert controller.flash.message != null
        assert Recipients.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/recipients/list'


        populateValidParams(params)
        def recipients = new Recipients(params)

        assert recipients.save() != null

        params.id = recipients.id

        def model = controller.show()

        assert model.recipientsInstance == recipients
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/recipients/list'


        populateValidParams(params)
        def recipients = new Recipients(params)

        assert recipients.save() != null

        params.id = recipients.id

        def model = controller.edit()

        assert model.recipientsInstance == recipients
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/recipients/list'

        response.reset()


        populateValidParams(params)
        def recipients = new Recipients(params)

        assert recipients.save() != null

        // test invalid parameters in update
        params.id = recipients.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/recipients/edit"
        assert model.recipientsInstance != null

        recipients.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/recipients/show/$recipients.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        recipients.clearErrors()

        populateValidParams(params)
        params.id = recipients.id
        params.version = -1
        controller.update()

        assert view == "/recipients/edit"
        assert model.recipientsInstance != null
        assert model.recipientsInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/recipients/list'

        response.reset()

        populateValidParams(params)
        def recipients = new Recipients(params)

        assert recipients.save() != null
        assert Recipients.count() == 1

        params.id = recipients.id

        controller.delete()

        assert Recipients.count() == 0
        assert Recipients.get(recipients.id) == null
        assert response.redirectedUrl == '/recipients/list'
    }
}
