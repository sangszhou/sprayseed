## add dependency
libraryDependencies += "com.gettyimages" %% "spray-swagger" % "0.5.1"

## create swagger route
should introduce runtime.universe._ for `typeOf`

## add annotation
```
@Api(value = "/pet", description = "Operations about pets")
trait PetHttpService extends HttpService {

  @ApiOperation(httpMethod = "GET", response = classOf[Pet], value = "Returns a pet based on ID")
  @ApiImplicitParams(Array(
      new ApiImplicitParam(name = "petId", required = false, dataType = "integer", paramType = "path", value = "ID of pet that needs to be fetched")
        ))
  @ApiResponses(Array(
    new ApiResponse(code = 400, message = "Invalid ID Supplied"),
    new ApiResponse(code = 404, message = "Pet not found")))
  def petGetRoute = get { path("pet" / IntNumber) { petId =>
    complete(s"Hello, I'm pet ${petId}!")
    } }
}
```

## Notes
1. for swagger route, empty.reduceLeft exception will be thrown when forget to put
```@Api(value = "/std", description = "Operations about pets")```
in front of the trait definition

2. all info from https://github.com/gettyimages/spray-swagger
