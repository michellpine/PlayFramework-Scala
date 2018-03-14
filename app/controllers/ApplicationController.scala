package controllers

import javax.inject._
import play.api.i18n._
import play.api.mvc._

@Singleton
class ApplicationController @Inject()(val controllerComponents: ControllerComponents)
  extends BaseController with I18nSupport {

  def index() = Action { implicit request =>
    Redirect(routes.ProductsController.list())
  }
}
