package com.bd

import org.springframework.dao.DataIntegrityViolationException

class Bd_report_distributionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [bd_report_distributionInstanceList: Bd_report_distribution.list(params), bd_report_distributionInstanceTotal: Bd_report_distribution.count()]
    }

    def create() {
        [bd_report_distributionInstance: new Bd_report_distribution(params)]
    }

    def save() {
        def bd_report_distributionInstance = new Bd_report_distribution(params)
        if (!bd_report_distributionInstance.save(flush: true)) {
            render(view: "create", model: [bd_report_distributionInstance: bd_report_distributionInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'bd_report_distribution.label', default: 'Bd_report_distribution'), bd_report_distributionInstance.id])
        redirect(action: "show", id: bd_report_distributionInstance.id)
    }

    def show() {
        def bd_report_distributionInstance = Bd_report_distribution.get(params.id)
        if (!bd_report_distributionInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'bd_report_distribution.label', default: 'Email Distribution'), params.id])
            redirect(action: "list")
            return
        }

        [bd_report_distributionInstance: bd_report_distributionInstance]
    }

    def edit() {
        def bd_report_distributionInstance = Bd_report_distribution.get(params.id)
        if (!bd_report_distributionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'bd_report_distribution.label', default: 'Email Distribution'), params.id])
            redirect(action: "list")
            return
        }

        [bd_report_distributionInstance: bd_report_distributionInstance]
    }

    def update() {
        def bd_report_distributionInstance = Bd_report_distribution.get(params.id)
        if (!bd_report_distributionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'bd_report_distribution.label', default: 'Email Distribution'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (bd_report_distributionInstance.version > version) {
                bd_report_distributionInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'bd_report_distribution.label', default: 'Bd_report_distribution')] as Object[],
                          "Another user has updated this Bd_report_distribution while you were editing")
                render(view: "edit", model: [bd_report_distributionInstance: bd_report_distributionInstance])
                return
            }
        }

        bd_report_distributionInstance.properties = params

        if (!bd_report_distributionInstance.save(flush: true)) {
            render(view: "edit", model: [bd_report_distributionInstance: bd_report_distributionInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'bd_report_distribution.label', default: 'Bd_report_distribution'), bd_report_distributionInstance.id])
        redirect(action: "show", id: bd_report_distributionInstance.id)
    }

    def delete() {
        def bd_report_distributionInstance = Bd_report_distribution.get(params.id)
        if (!bd_report_distributionInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'bd_report_distribution.label', default: 'Email Distribution'), params.id])
            redirect(action: "list")
            return
        }

        try {
            bd_report_distributionInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'bd_report_distribution.label', default: 'Email Distribution'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'bd_report_distribution.label', default: 'Email Distribution'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
