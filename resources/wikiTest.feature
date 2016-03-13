Feature: Wiki tests
  @TC1
  Scenario: Verify that click on mosaic ball throws you to the Main page
    Given on Current Page I click Random Page link
    When on Current Page I click Mosaic Ball element
    Then on Main Page I see that the Main Page title is "Википедия — свободная энциклопедия"


  @TC2
  Scenario: Verify the number of predicative suggestions
    Given I am on the Main Page
    When on Top Panel I input "а" to the Search field
    Then on Top Panel I see "10" predicative suggestions


  @TC3
  Scenario:Verify that list of predicative suggestions at least contains the following: Аур, Аура, Аурих, Аурано, Ауриго, Ауро, Ауреа
    Given I am on the Main Page
    When on Top Panel I input "аур" to the Search field
    Then on Top Panel I see at least the following predicative suggestions: Аур, Аура, Аурих, Аурано, Ауриго, Ауро, Ауреа


  @TC4
  Scenario:Verify Participation list content
    When I am on the Main Page
    Then on Left Panel I see Participation List: Сообщить об ошибке, Портал сообщества, Форум, Свежие правки, Новые страницы, Справка, Пожертвовать



  @TC5
  Scenario: Go to favorite page and verify its title
    Given I am on the Main Page
    When on Main Page I see Favorite Page link
    When on Main Page I click Favorite Page link
    Then on Current Page I see correct Favorite Page title



