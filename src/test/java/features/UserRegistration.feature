Feature: User Registration
		I want to check that the user can register in our e-commerce website
		
		
		Scenario Outline: User Registration Scenario
		Given The user in homepage
		When I click on register link
		And I entered "<firstname>","<lastname>","<email>","<password>"
		Then The registration is completed successfully
		
		Examples: 
		| firstname | lastname | email | password |
		| Wesam | Kassem | wesam@test.com | 123123 |
		| Harry | Kane | harry@cucumber.test | 123456 |