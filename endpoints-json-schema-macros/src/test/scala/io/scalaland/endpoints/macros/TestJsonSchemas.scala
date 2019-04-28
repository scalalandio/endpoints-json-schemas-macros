package io.scalaland.endpoints.macros

import scala.reflect.ClassTag

object TestJsonSchemas
  extends JsonSchemasTestInterpreter
    with ExampleDomain {

  override def typeName(ct: ClassTag[_]): String =
    TypeNames.noPackageName(ct)
}
