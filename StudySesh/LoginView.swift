//
//  LoginView.swift
//  studysesh
//
//  Created by Ananya Guntur on 6/20/24.
//

import SwiftUI

struct LoginView: View {
    @State private var email = ""
    @State private var password = ""
    var body: some View {
        
        NavigationStack{
            VStack{
                //image
            
                    Text("Login")
                        .font(.largeTitle)
                        .fontWeight(.bold)
                        .padding(.top, 30)
                        .padding(.leading, 20)
                        .frame(maxWidth: .infinity, alignment: .leading)
                VStack(spacing: 24){
                    InputView(text: $email,
                              title: "Email Address",
                              placeholder:"name@example.com")
                    .autocapitalization(.none)
                    
                    InputView(text: $password,
                              title: "Password",
                              placeholder: "Enter Your Password",
                              isSecureField: true)
                    
                }
                .padding(.horizontal)
                .padding(.top, 12)
                
                Button{
                    print("Login")
                    
                } label: {
                    HStack{
                        Text("Sign In")
                            .fontWeight(.semibold)
                        Image(systemName: "arrow.right")
                    }
                    .foregroundColor(.white)
                    .frame(width: UIScreen.main.bounds.width - 32, height: 48)
                }
                .background(Color(.systemBlue))
                .cornerRadius(30)
                .padding(.top)
                
                Spacer()
                
                NavigationLink{
                    RegistrationView()
                        .navigationBarBackButtonHidden(true)
                    
                } label: {
                    HStack{
                        Text("Don't Have An Account?")
                        Text("Sign Up")
                            .fontWeight(.bold)
                        
                    }
                }
            }
        }
    }
}

struct LoginView_Previews: PreviewProvider {
    static var previews: some View {
        LoginView()
    }
}
