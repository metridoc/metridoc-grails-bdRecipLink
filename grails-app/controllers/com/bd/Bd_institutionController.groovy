package com.bd

//import org.springframework.dao.DataIntegrityViolationException

class Bd_institutionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 20, 100)
        [bd_institutionInstanceList: Bd_institution.list(params), bd_institutionInstanceTotal: Bd_institution.count()]
    }

    def create() {
        [bd_institutionInstance: new Bd_institution(params)]
    }

    def save() {
        def bd_institutionInstance = new Bd_institution(params)
        if (!bd_institutionInstance.save(flush: true)) {
            render(view: "create", model: [bd_institutionInstance: bd_institutionInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'bd_institution.label', default: 'Bd_institution'), bd_institutionInstance.id])
        redirect(action: "show", id: bd_institutionInstance.id)
    }

    def show() {
        def bd_institutionInstance = Bd_institution.get(params.id)
        if (!bd_institutionInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'bd_institution.label', default: 'Institution'), params.id])
            redirect(action: "list")
            return
        }

        [bd_institutionInstance: bd_institutionInstance]
    }

    def edit() {
        def bd_institutionInstance = Bd_institution.get(params.id)
        if (!bd_institutionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'bd_institution.label', default: 'Bd_institution'), params.id])
            redirect(action: "list")
            return
        }

        [bd_institutionInstance: bd_institutionInstance]
    }

    def update() {
        def bd_institutionInstance = Bd_institution.get(params.id)
        if (!bd_institutionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'bd_institution.label', default: 'Bd_institution'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (bd_institutionInstance.version > version) {
                bd_institutionInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'bd_institution.label', default: 'Bd_institution')] as Object[],
                          "Another user has updated this Bd_institution while you were editing")
                render(view: "edit", model: [bd_institutionInstance: bd_institutionInstance])
                return
            }
        }

        bd_institutionInstance.properties = params

        if (!bd_institutionInstance.save(flush: true)) {
            render(view: "edit", model: [bd_institutionInstance: bd_institutionInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'bd_institution.label', default: 'Bd_institution'), bd_institutionInstance.id])
        redirect(action: "show", id: bd_institutionInstance.id)
    }

    def delete() {
        def bd_institutionInstance = Bd_institution.get(params.id)
        if (!bd_institutionInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'bd_institution.label', default: 'Institution'), params.id])
            redirect(action: "list")
            return
        }

        try {
            bd_institutionInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'bd_institution.label', default: 'Institution'), params.id])
            redirect(action: "list")
        }
        catch (Exception e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'bd_institution.label', default: 'Institution'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
