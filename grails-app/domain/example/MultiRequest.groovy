package example

class MultiRequest extends Request {

    static hasMany = [partialRequests: PartialRequest]
}
