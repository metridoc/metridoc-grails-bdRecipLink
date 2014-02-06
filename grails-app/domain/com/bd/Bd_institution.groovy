package com.bd

class Bd_institution {

	static hasMany = [report_distribution:Bd_report_distribution]

    String catalog_code
    String institution
    String library_id

    static constraints = {
        institution(blank: false)
        library_id(blank: false)
        catalog_code(blank: false)
    }

	String toString(){
		return "${institution} - ${library_id}"
	}
}
