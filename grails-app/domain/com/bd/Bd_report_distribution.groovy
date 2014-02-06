package com.bd

class Bd_report_distribution {

	String email_addr
	String library_id

	static belongsTo = [institution:Bd_institution]

    static constraints = {
        email_addr (email: true, blank: false)
        library_id(blank: false)
    }
}
