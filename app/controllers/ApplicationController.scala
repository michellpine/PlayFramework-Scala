package controllers

import javax.inject._
import play.api.i18n._
import play.api.mvc._

@Singleton
class ApplicationController @Inject()(cc: ControllerComponents,messagesApi: MessagesApi)
  extends AbstractController(cc) with I18nSupport {

  def index() = Action { implicit request =>
    Redirect(routes.ProductsController.list())
  }
}
